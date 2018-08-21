import numbers

a=['a','b','c']
print(pow(2,len(a)))

def printBybitOp():
    for i in range(pow(2, len(a))):
        ind = 0
        pos = i
        s = set()
        while pos != 0:
            if pos & 1 == 1:
                s.add(a[ind])
            pos = pos >> 1
            ind += 1
        print(s)

def printByRec():
    s=set()
    callHelper(a,s,0)


def callHelper(a,s,i):
    if i==len(a):
        # s.add(a[i])
        print(s)
    else:
        # adding ith element
        s1=set()

        for item in s:
            s1.add(item)
        s1.add(a[i])
        callHelper(a,s1,i+1)
        # not adding ith element
        callHelper(a,s,i+1)

def test():
    s=set()
    print(s)
    s.add('a')
    s.add('b')
    s.add('c')

    print(s)
    arr=[]
    for k in s:arr.append(k)
    print(arr)


def longestSubsequence(seq):
    gc=''
    gf=0
    lc=''
    lf=0
    for i in seq:
        if i==lc:
            lf+=1
        else:
            if gf<lf:
                gc=lc
                gf=lf
            lc=i
            lf=1
    print("letter is: "+str(gc)+"  frequency is ::"+str(gf))

def towerHoppable(arr):
    print(arr)
    if len(arr)==0:
        return True
    for i in reversed(range(len(arr))):
        if len(arr)-i<=arr[i]:
            return towerHoppable(arr[:i])
    return False

if __name__=="__main__":
    longestSubsequence("AABCDDDDBBBEA")
    arr=[1,0]
    print(towerHoppable(arr))