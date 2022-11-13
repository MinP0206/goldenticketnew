<!-- PROJECT LOGO -->
<br />


<h3 align="center">Golden TicketNew - Movie Tickets Online Booking</h3>
  <p align="center">
     Cre: idtruoc
     <br/>

  
  </p>
</div>


## Golden TicketNew - Movie Tickets Online Booking
Basic Website Golden TicketNew - Movie Tickets Online Booking.  <br/>
This project was created for the TLCN...(add more).
(Tran Cong Tu)

## Contributors
- idtruoc a.k.a Trương Minh Phương
- Cmit V a.k.a Lê Quốc Vinh

## Framework and Technology used
### Requirement
- npm version 8.1.2
```sh
npm install -g npm@8.1.2
```
- java SE DEvelopment Kit version 11
```sh
- https://www.oracle.com/java/technologies/downloads/#java11
```
- For Backend Code, i used Springboot and IntelliJ IDEA as IDE for programming, you can use Eclipse instead of IntelliJ IDEA
```sh
- https://www.jetbrains.com/idea/download/#section=windows
- https://www.eclipse.org/downloads/
```
- ReactJS (Front-End)
- Springboot (Back-End)
- Database (MongoDB) 
```sh
For database i use https://cloud.mongodb.com
```

## How to run the project on local (Follow the sequence)
### Back-End
1. Go to .env file change the string connection to database (MongoDB)
2. Go to the folder api, then type: "yarn start"
3. The Backend will start on localhost:5000

### Front-End 
1. Go to folder fe -> src -> helper, open file axios.js and changing this line: const baseURL = "{your backend hosted URL}";. For my project it is: const baseURL = "http://localhost:5000/api";
2. Go to the folder fe, then type: "npm start"
3. The Frontend will start on localhost:3000

## Contribution
Any information please contact me through this email: 
```sh
minhphuongtmp2001@gmail.com
lequocvinh2001@gmail.com
```
