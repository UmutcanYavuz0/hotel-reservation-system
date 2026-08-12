import requests

def getrooms():
    response=requests.get("http://localhost:8080/user/getrooms")
    result=response.text
    array=result.split("{")
    for x in array:
        if x=="{":
            print("\n")
        else:
            print(x)
    
    

def addRoom():
    odaAdı=input("oda adı gir  ")
    
    personcapacity=input("oda kişi sayısı gir  ")

    params={'odaAdı':odaAdı,'personcapacity':personcapacity}
    requests.post("http://localhost:8080/admin/add/room",params=params)

def deleteroom():
    odaid=input("oslineek oda id si gir  ")
    

    params={'id':odaid}
    requests.post("http://localhost:8080/admin/delete/room",params=params)


def getRoomProperties():
    response=requests.get("http://localhost:8080/admin/get/rooms")
    result=response.text
    array=result.split("{")
    for x in array:
        if x=="{":
            print("\n")
        else:
            print(x)


def deleteallrooms():
    requests.delete("http://localhost:8080/admin/delete/allrooms")
    print("tüm odalar silindi")

def roomrezerve():
    odaaadı=input("room name ")
    gün=input("gün  ")
    kullanıcıadı=input("kullanıcı adı  ")

    params={'roomname':odaaadı,'day':gün,'user':kullanıcıadı}
    response=requests.post("http://localhost:8080/user/rezerve/room",params=params)
    print(response.text)

def deleterezervation():
    id =input("id ")
    params={'id':id}
    response=requests.post("http://localhost:8080/user/delete/rezervation",params=params)
    print(response.text)


def getrezervations():
    response=requests.get("http://localhost:8080/admin/get/rezervations")
    result=response.text
    array=result.split("{")
    for x in array:
        if x=="{":
            print("\n")
        else:
            print(x)


getrezervations()