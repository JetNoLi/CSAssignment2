import subprocess

fileName = "SetData_.txt"
outFileName = "LSBSTAppOutputData_.txt"
program = "LSBSTApp"

for x in range(1,11):
    curFileName = fileName.replace("_",str(x)) # sample files = curFileName
    with open(fileName,"w") as f:
        subprocess.run(["shuf", "-n", str(x*297),"Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"], stdout = f, text = True)
    
    with open(curFileName, "w") as f:
        subprocess.run(["uniq",fileName], stdout = f, text = True)
    
    subprocess.run(["rm",fileName])

    for y in range(2):
        
        if (y ==1):
            outFileName = "LSAVLTreeAppOutputData_.txt"
            program = "LSAVLTreeApp"

        curOutFileName = outFileName.replace("_", str(x))

        with open(curOutFileName, "w") as f:
            setDataFile = open(curFileName, "r")
            lines = setDataFile.readlines()
            for i in lines:
                data = i
                data = data.split(" ",2)[0]

                
                #if (data[6] == " "):
                   # data[0:6]
                    #print(data)
                
                #data = data.rstrip()
                info = data.split("_")

                print(info)
                subprocess.run(["java", program, info[0], info[1], info[2], curFileName], stdout = f, text = True)



            
