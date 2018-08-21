from kafka import KafkaProducer
from tweepy import Stream
from tweepy import OAuthHandler
from tweepy.streaming import StreamListener
import time
import json

producer = KafkaProducer(bootstrap_servers="localhost:9092")


#consumer key, consumer secret, access token, access secret.
ckey="FX5rcIyjlRf4dMXpr6gluo6ti"
csecret="pDiU4wwfgRsxBWrLYM32iTbjE8zeqbmRAoUmWg363l28aKhGFm"
atoken="259385556-UFthRs9p6PFLQSeOk6UD40c8kIc2anHBGWNOD0LR"
asecret="qZyTXtBfzh0H0dg97nXFuUCDNTZ2dviJ0dAphZMkBJzAt"

class listener(StreamListener):

    def on_data(self, data):
        msg = json.loads(data)
        if msg["text"]:
            producer.send("TwitterFeed",msg['text'].encode('utf-8'))
        return(True)

    def on_error(self, status):
        print(status)

auth = OAuthHandler(ckey, csecret)
auth.set_access_token(atoken, asecret)

twitterStream = Stream(auth, listener())
twitterStream.filter(track=["india"])


producer.flush()