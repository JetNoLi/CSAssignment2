import subprocess
import random

fileName = "_Testing.txt"


with open("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt","r") as f:
    lines = f.readlines()
    randomLines = random.sample(lines,3)

    for i in range(2):
        app = "LSBSTApp"

        if (i == 1):
            app = "LSAVLTreeApp"

        currentFileName = fileName.replace("_", app)

        with open(currentFileName,"w") as outFile:
            for j in range(3):
                outFile.write("The Random Line Chosen is: " + randomLines[j])
                outFile.write("\n")

                info = randomLines[j].split(" ", 2)
                data = info[0].split("_")
                zones = info[1].split(", ")
    
                outFile.write("Thus the stage, day, startTime is " +data[0] +", " + data[1] + ", " + data[2])
                outFile.write("\n")

                

                
                
        
        
        
        
    
