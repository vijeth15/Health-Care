import os 
os.system("git init")
os.system("git add .")
os.system('git commit -m "first commit"')
val=input("Enter your resp to store : ")
os.system(val)
os.system("git branch -M main")
os.system("git push -u origin main")

