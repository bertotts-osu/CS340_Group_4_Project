export async function getMySQLResults() {
  // fetch function returns a Promise that resolves to a Response object representing the server's response to your request.
  const response = await fetch("http://classwork.engr.oregonstate.edu:4569");
  console.log("trying to get data from MySQL")

  // Note: I do not handle the thrown error explicitly b/c it is taken care of by the TanStack library
  if (!response.ok) {
    // ok is a boolean method of the Response object
    const error = new Error("An error occured while fetching the MySQLResult");
    error.code = response.status; //tags the HTTP status code of the response to the error
    error.info = await response.json(); //converts the response body to JSON in order to include more details about the error provided by the server
    throw error;
  }
  // if there is no error, returns the result of the json
  const result = await response.json();
  console.log(`response: ${result}`)
  return result;
}
