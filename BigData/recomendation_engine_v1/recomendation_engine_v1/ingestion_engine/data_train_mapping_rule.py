from ..interfaces.rule_interface import RuleInterface

class DataTrainMapping(RuleInterface):

    def __init__(self):
        pass

    def applyRule(self,rule):
        pass

    def mapFeatureData(self,config):
        pass

    def mapLabelData(self,config):
        pass

    def applyTransformation(self,key, obj, transObject, path=""):
        if isinstance(obj, str) or isinstance(obj, list) or isinstance(obj, bool) or isinstance(obj, int):
            try:
                transObject[key[path]] = obj
            except KeyError:
                pass
            path = None

            return key, path, transObject
        elif isinstance(obj, dict):
            for k, v in obj.items():
                temp = path
                if path == "":
                    path = str(k)
                else:
                    path += "." + k
                key, path, transObject = self.applyTransformation(key, v, transObject, path)
                if path == None:
                    path = temp
            return key, path, transObject
        else:
            path = None
            return key, path, transObject
        return key, path, transObject

