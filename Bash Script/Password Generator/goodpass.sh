#!/bin/bash

#init words to generate password
declare -a words
words=(foo bar developer java csharp android ios swift php)

#Define variables
filename=""
a=1
strong=0
len=${#words[@]}
w=$(( $RANDOM % $len + 1 ))
n=1
countVariables=$(($#+1))

#Check if first command variable is file name to save
if [[ "$1" != "" && "$1" != "-s" && "$1" != "-n" && "$1" != "-w" ]]
then
    filename="$1"
fi

#Check all command variables
for((i=0;i<$countVariables;i++))
do
    if [[ ${!i} == "-w" ]]
    then
        nextParams=$(($i+1))
        w=${!nextParams}
    fi
    if [[ ${!i} == "-s" ]]
    then
        strong=1
    fi
    if [[ ${!i} == "-n" ]]
    then
        nextParams=$(($i+1))
        n=${!nextParams}
    fi
done

#Init result
result=""

#Generate n password (default n=1)
for((j<0;j<$n;j++))
do
    tmp=""

    #Generate password from w words
    for((i=0;i<$w;i++))
    do
        escape=0
        while [ $escape -eq 0 ]
        do
            #random word from words
            index=$(( $RANDOM % $len ))
            item=${words[index]}

            #Check if result has word, if word not exist break while loop
            if [[ "$tmp" == *"$item"* ]]
            then
                escape=0
            else
               
                tmp="$tmp$item"
                escape=1
            fi
        done 
        
    done

    #append password to result
    if [[ $result == "" ]]
    then
        result="$tmp"
    else
        result=$"$result\n$tmp"
    fi
done

#Define vowels
vowels="aeiou"

#Define Char to replace
numberSpecialChars="0123456789!@#$%^&*"

#Check each char in password result
itemlength=${#result}
numberLength=${#numberSpecialChars}
for((c=0;c<$itemlength;c++)){
    rdValue=$(( $RANDOM % $numberLength ))
    rdChar=${numberSpecialChars:$rdValue:1}

    #get char at index
    char=${result:$c:1}

    #Check if char is vowel
    if [[ "$vowels" == *"$char"* ]]
    then

        #Check if need replace char
        needReplace=0
        if [[ "$strong" == "1" ]]
        then
            needReplace=1
        else
            needReplace=$(( $RANDOM % 2 ))
        fi

        #Replace char
        if [[ needReplace -eq 1 ]]
        then

            end=$((itemlength-c))
            start=$((c+1))
            result="${result:0:c}$rdChar${result:start:end}"
        fi
    fi
}
echo -e $result

#Save to file
if [[ $filename != "" ]]
then
    echo -e $result > $filename
fi