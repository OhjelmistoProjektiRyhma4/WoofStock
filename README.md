# WoofStock
Dog product inventory tracker.
<img width="760" alt="Sprint1_käyttöliittymäkuva" src="https://github.com/OhjelmistoProjektiRyhma4/k24Tiimi4BackEnd/assets/148938257/8c88dabf-5508-423e-b7cc-fbe33519a303">
^Sprint 1 käyttöliittymäkuva rautalankamalli



DogProductInventory Api

General

<h2>DogProductInventory API contains dogproducts and manufacturers</h2>

<h4>Dogproduct attributes:</h4>

<p>name(String)</p>
<p>color(String)</p>
<p>price(int)</p>
<p>manufacturer(Manufacturer)</p>

<h4>Manufacturer attributes:</h4>

<p>name(String)</p>
<p>address(String)</p>
<p>phone(String)</p>


<h4>Root address for API content</h4>

localhost:8080

<h4>Get a list of dogproducts</h4>

<p>Method: GET</p>
<p>/dogproducts</p>

<h4>Get a dogproduct by id </h4>

<p>Method: GET</p>
<p>/dogproducts/{id}</p>

<h4>Add new dogproduct</h4>

<p>Method: POST</p>
<p>/dogproducts</p>
<p>Header: ‘content-type’: ‘application/json’</p>
<p>Body:</p>

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

<h4>Update dogproduct</h4>

<p>Method: PUT</p>
<p>/dogproducts/{id}</p>
<p>Header: ‘content-type’: ‘application/json’</p>
<p>Body:</p>

{
name: ‘new name’,
color: ‘new color’,
price: 5
}

<h4>Get a list of manufacturers</h4>

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
