# ubs
UBS - API REST utilizando Spring Boot

EndPoints:

/*** CREATE NEW USER ***/
/user

example: POST
{
	"name": "Rafael",
	"email": "rafael@gmail.com",
	"password": "9999999"
}

/*** SIGN IN ***/
/login

example: POST
{
	"email": "bionexo@email.com",
	"password": "123456"
}

/*** GET ALL UBS ***/
GET
/ubs 

/*** GET CLOSEST UBSs ***/
/ubs

example: POST
{
	"latitude": -27.2108001,
	"longitude": -49.6446024
}

/*** GET UBS DETAILS ***/
GET
/ubs/{id} 
