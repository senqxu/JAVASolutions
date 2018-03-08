package com.company;

/*@subject  请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy
        则经过替换之后的字符串为We%20Are%20Happy*/

public class replaceSpace {
    public static String replaceSpace(StringBuffer str){
        //Strategies 1.从后往前，先统计字符串个数和空格个数spaceNum
        //            2.使用两个指针，替换前索引为indexOld,替换后为indexNew
        int spaceNum = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == ' '){
                spaceNum++;
            }
        }

        int indexOld = str.length() - 1;
        int indexNew = indexOld  + spaceNum*2;//每次替换一个空格，索引增加2位
        int newLength = indexNew + 1;
        str.setLength(newLength);

        //开始替换
        while(indexOld >= 0 && indexNew >= indexOld){
            if(str.charAt(indexOld) != ' '){
                str.setCharAt(indexNew--,str.charAt(indexOld));

            }
            else {

                str.setCharAt(indexNew--,'0');
                str.setCharAt(indexNew--,'2');
                str.setCharAt(indexNew--,'%');
            }
            --indexOld;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("we Are Your Friends");

        System.out.println(replaceSpace(sb));
    }
}
