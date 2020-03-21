import subprocess
import random

fileName = "_Testing.txt"


with  open("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt","r") as f:
    lines = f.readlines()
    randomLines = random.sample(lines,3)

    for i in range(2):
        app = "LSBSTApp"

        if (i == 1):
            app = "LSAVLTreeApp"

        currentFileName = fileName.replace("_", app)

        with open(currentFileName,"w") as outFile:
            for j in range(3):
                outFile.write(str(j+1)  + ") \n")
                outFile.write("The Random Line Chosen is: " + randomLines[j])
                outFile.write("\n")

                info = randomLines[j].split(" ")
                data = info[0].split("_")
                zones = "[" 
                for x in info:
                    if (x == info[0]):
                        continue

                    else:
                        zones += x + " "

                zones = zones[0:(len(zones)-2)]
                

                
                outFile.write("Thus the stage, day, startTime is " +data[0] +", " + data[1] + ", " + data[2])
                outFile.write("\n")
                outFile.write("Using these as input, i.e : java " + app + " " +data[0] + " " + data[1] + " " + data[2])
                outFile.write("\n")
                outFile.write("It Should return " + zones + "] as the zones affected \n")
                outFile.write("The " + app + " outputs:" + "\n")
                
                output = subprocess.run(["java",app, data[0], data[1], data[2], "T"], stdout = subprocess.PIPE, text = True)
                
                outputDisplayable = output.stdout.split("\n")
                outFile.write(outputDisplayable[0] + "\n \n")


                
                
                
                 

                

                

                
                
        
        
        
        
    
