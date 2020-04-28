import subprocess

fileName = "SetData_.txt"

findCompArrayBST = []
insertCompArrayBST = []

findCompArrayAVL = []
insertCompArrayAVL = []

for x in range(1,11):
    curFileName = fileName.replace("_",str(x)) # sample files = curFileName
    with open(fileName,"w") as f:
        subprocess.run(["shuf", "-n", str(x*297),"Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"], stdout = f, text = True)
    
    with open(curFileName, "w") as f:
        subprocess.run(["uniq",fileName], stdout = f, text = True)
    
    subprocess.run(["rm",fileName])

    for y in range(2):
        outFileName = "LSBSTAppOutputData_.txt"
        program = "LSBSTApp"

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

                info = data.split("_")
                
                subprocess.run(["java", program, info[0], info[1], info[2], curFileName], stdout = f, text = True)
       
        
        with open(curOutFileName, "r+") as f:
            lines = f.readlines()
            
            findCounters = []
            insertCounters = []

            for i in lines:
                if ((lines.index(i)+1)%2 == 0): # if it is find
                    counter = i.split(" ")
                    findCounters.append(counter[1])

                else:
                    counter = i.split(" ")
                    insertCounters.append(counter[1])

            
            best = [0,0] #Find,Insert
            worst = [0,0]
            averageC = [0,0]
            average =[0,0]
            
            count = 0

            for q in findCounters:
                comparable = int(q)
                if (count == 0):
                    best[0] = comparable
                    worst[0] = comparable
                    averageC[0] += comparable
                    averageC[1] += 1

                else:
                    
                    if (comparable < best[0]):
                        best[0] = comparable

                    if (comparable > worst[0]):
                        worst[0] = comparable

                    averageC[0]= averageC[0] +comparable
                    averageC[1]+= 1
                
                count += 1
                
            average[0] = averageC[0]/averageC[1]
            averageCalc = [0,0]
            
            count = 0

            for t in insertCounters:
                
                comparable = int(t)
                if (count == 0):
                    best[1] = comparable
                    worst[1] = comparable
                    averageCalc[0] = comparable
                    averageCalc[1] += 1

                else:
                    if (comparable < best[1]):
                        best[1] = comparable

                    if (comparable > worst[1]):
                        worst[1] = comparable

                    
                    averageCalc[0]+= comparable
                    averageCalc[1]+= 1

                count+=1

            average[1] = averageCalc[0]/averageCalc[1]
            print(curOutFileName)
            
            outputFind = "Find (B,W,A): " + str(best[0]) + ", " + str(worst[0]) + ", " + str(average[0])
            outputInsert ="Insert (B,W,A): " + str(best[1]) + ", " + str(worst[1]) + ", " + str(average[1])
            
            f.write(outputFind)
            f.write("\n")
            f.write(outputInsert)
            f.write("\n")

            if y == 0:
                findCompArrayBST.append(str(x) + ".) " + outputFind)
                insertCompArrayBST.append(str(x) + ".) " + outputInsert)
            
            elif y == 1:
                findCompArrayAVL.append(str(x) + ".) " + outputFind)
                insertCompArrayAVL.append(str(x) + ".) " + outputInsert)
            
with open("comparisonsBST","w") as f:
    for i in range(10):
        f.write(findCompArrayBST[i])
        f.write("\n")
        f.write(insertCompArrayBST[i])
        f.write("\n")

with open("comparisonsAVL","w") as f:
    for i in range(10):
        f.write(findCompArrayAVL[i])
        f.write("\n")
        f.write(insertCompArrayAVL[i])
        f.write("\n")
            
                



            
