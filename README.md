# WoofStock
Dog product inventory tracker.
<img width="760" alt="Sprint1_käyttöliittymäkuva" src="https://github.com/OhjelmistoProjektiRyhma4/k24Tiimi4BackEnd/assets/148938257/8c88dabf-5508-423e-b7cc-fbe33519a303">
^Sprint 1 käyttöliittymäkuva rautalankamalli



DogProductInventory Api

General

<h2>DogProductInventory API contains dogproducts and manufacturers</h2>

Dogproduct attributes:

name(String)
color(String)
price(int)
manufacturer(Manufacturer)

Manufacturer attributes:

name(String)
address(String)
phone(String)


Root address for API content

localhost:8080

Get a list of dogproducts

Method: GET
 /dogproducts

Get a dogproduct by id 

Method: GET
/dogproducts/{id}

Add new dogproduct

Method: POST
/dogproducts
Header: ‘content-type’: ‘application/json’
Body:

{
name: ‘some name’,
color: ‘some color’,
price: 5
}

Optional: add also manufacturer to the dogproduct:

{
name: ‘some name’,
color: ‘some color’,
price: 5,
manufacturer: { id: 2 }
}

Update dogproduct

Method: PUT
/dogproducts/{id}
Header: ‘content-type’: ‘application/json’
Body:

{
name: ‘new name’,
color: ‘new color’,
price: 5
}

Get a list of manufacturers

Method: GET
/manufacturers

Get manufacturer by id

Method: GET
/manufacturers/{id}

Add new manufacturer:

Method:POST
/manufacturers
Header: ‘content-type’: ‘application/json’
Body:

{
name: ‘some name’
address: ‘some address’
phone: some number
}

Update manufacturer:

Method: PUT
/manufacturers/{id}
Header: ‘content-type’: ‘application/json’
Body:

{
name: ‘new name’
address: ‘new address’
phone: new number
}
