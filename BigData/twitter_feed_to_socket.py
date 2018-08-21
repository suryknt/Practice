from tweepy import Stream
from tweepy import OAuthHandler
from tweepy.streaming import StreamListener
import socket
import json

#consumer key, consumer secret, access token, access secret.
ckey="FX5rcIyjlRf4dMXpr6gluo6ti"
csecret="pDiU4wwfgRsxBWrLYM32iTbjE8zeqbmRAoUmWg363l28aKhGFm"
atoken="259385556-UFthRs9p6PFLQSeOk6UD40c8kIc2anHBGWNOD0LR"
asecret="qZyTXtBfzh0H0dg97nXFuUCDNTZ2dviJ0dAphZMkBJzAt"

class listener(StreamListener):

    def __init__(self, csocket):
        self.client_socket = csocket

    def on_data(self, data):
        try:
            msg = json.loads(data)
            print(msg['text'].encode('utf-8'))
            self.client_socket.send(msg['text'].encode('utf-8'))
            return True
        except BaseException as e:
            print("Error on_data: %s" % str(e))
        return True

    def on_error(self, status):
        print(status)

def sendData(c_socket):
    auth = OAuthHandler(ckey, csecret)
    auth.set_access_token(atoken, asecret)
    twitterStream = Stream(auth, listener(c_socket))
    twitterStream.filter(track=["ai"])


if __name__ == "__main__":
  s = socket.socket()         # Create a socket object
  host = "172.16.99.228"      # Get local machine name
  port = 5555                 # Reserve a port for your service.
  s.bind((host, port))        # Bind to the port

  print("Listening on port: %s" % str(port))

  s.listen(5)                 # Now wait for client connection.
  c, addr = s.accept()        # Establish connection with client.

  print( "Received request from: " + str( addr ) )

  sendData( c )