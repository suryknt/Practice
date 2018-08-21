from abc import abstractmethod,ABCMeta

class RuleInterface(metaclass=ABCMeta):

    @abstractmethod
    def applyRule(self):
        pass
