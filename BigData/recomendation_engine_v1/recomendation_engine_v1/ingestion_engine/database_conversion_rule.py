from ..interfaces.rule_interface import RuleInterface
from abc import abstractmethod,ABCMeta
from recomendation_engine_v1 import kafkaProducer
from bson.json_util import dumps

class DatabaseConversionRule(RuleInterface,metaclass=ABCMeta):

    def __init__(self):
        self.__producer__ = kafkaProducer.getProducer()

    @abstractmethod
    def applyRule(self):
        pass

    def streamData(self,data):
        self.__producer__.send("engine_test", dumps(data))

    @abstractmethod
    def readData(self):
        pass
