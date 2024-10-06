// this is a single line comment
console.log(`Hellow, World!`);

// variables are used to store data in computer memory
let someVariable;
console.log(someVariable); // --> undefined

// default value for a variable defined in JS is 'undefined'

someVariable = "some value";
console.log(someVariable);

// constants are used to store values in the computer memory which are not
// going to change in the future
const someConstant = 8;
console.log(someConstant);

// someConstant = 9; --> this will produce a TypeError

// below are the primitive types available in JS
let stringValue = "this is a string value";
let numberValue = 10;
let booleanValue = true;
let undefinedValue = undefined;
let nullValue = null;

// JS is a dynamically typed language, which means the data type of a variable in
// JS can be changed during the execution of a program
someVariable = 9;
console.log(typeof someVariable);

someVariable = "now this is a string type variable";
console.log(typeof someVariable);

// below is a JS object
let personObject = {
  personName: "Rajesh Sinha",
  personAge: 28,
  isPersonAlive: true,
};
console.log(typeof personObject);
console.log(personObject);

// we can access the properties of an object either by dot notation
// or by bracket notation
console.log(personObject.personName); // dot notation
console.log(personObject["personName"]); // bracket notation

// arrays are used to store a list of data in JS
let someArray = [1, "some string value", true, undefined, null, {}];
console.log(typeof someArray);
console.log(someArray);

// any specific element in an array can be accessed using it's corresponding
// index
console.log(someArray[0]);
console.log(someArray[1]);

// the number of elements present in an array can be checked using the length
// property
console.log(someArray.length);

function someFunction(personName) {
  console.log(`Hi ${personName}! this is from a function`);
}

someFunction("Rajesh");

const someArrowFunction = (firstNumber, secondNumber) => {
  return firstNumber + secondNumber;
};

console.log(someArrowFunction(1, 2));
