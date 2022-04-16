from collections import deque

class Solution:
    def decodeString(self, s: str) -> str:
        numStack = deque()
        strStack = deque()
        curNum = 0
        curStr = ''
        
        for cur in s:
            if cur.isdecimal():
                curNum = curNum*10 + int(cur)      
            elif cur.isalpha():
                curStr += cur
            elif cur == '[':
                numStack.append(int(curNum))
                strStack.append(curStr)
                curNum = 0
                curStr = ''
            elif cur == ']':
                multiplier = numStack.pop()
                repeatedString = multiplier * curStr
                curStr = strStack.pop()
                curStr = curStr + repeatedString

        return curStr
