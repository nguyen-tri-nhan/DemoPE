Practical Test
The details of the Books of an organization are stored in the xml in the tabular format. The data of the Books with the following structure.

```
<?xml version="1.0" encoding="UTF-8"?>
<garden>
    <flower id="f1" isAvailabe="true">
        <name>Flower 1</name>
        <description>Des Flower 1</description>
        <quantity>10</quantity>
        <price>12</price>
        <season name="spring"/>
    </flower>
    <flower id="f2" isAvailabe="false">
        <name>Flower 2</name>
        <description>Des Flower 2</description>
        <quantity>10</quantity>
        <price>12</price>
        <season name="summer"/>
    </flower>
    <flower id="f3" isAvailabe="true">
        <name>Flower 3</name>
        <description>Des Flower 3</description>
        <quantity>10</quantity>
        <price>12</price>
        <season name="autumn"/>
    </flower>
</garden>
```
Create a Java web application, which can be used to manage the Garden.  The application initially displays a menu with the following options:
1.  Add flower. (2đ)
When a flower enters the first choice "Add Flower ", the application starts accepting all the details of the new flower – and store it into an xml file – if flower is existed, the flower will be not insert to xml.

2.  Search flowers by price (from price to price). (4đ)
For selecting the choice 2 to search flowers by price (from price to price). If the application finds a match and attribute isAvailabe="true"”
The data grid of flowers is shown with Number, Id, Name, Price, Season
3.  When flower input all the details of the flower and click “Update”, all information of flower will be updated to xml. (2đ)
