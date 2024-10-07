import { useQuery } from "@tanstack/react-query"; //wrapper for HTTP requests (do not send them itself)

import { getMySQLResults } from "../util/http";

export default function HomePage() {
    //pass object to useQuery
  // useQuery returns an object that we get the relevent parts by using Object Restructuring
  //    * data = data returned by fetching function
  //    * isPending = tells us whether request is still waiting or has been given a response\
  //    * isError = lets us know if an error occurred (fetching function must throw the error)
  const { data, isPending, isError, error } = useQuery({
    queryKey: ['events'], //array of internal values that TanStack uses to cache existing data for reuse
    queryFn: getMySQLResults //required param that returns a promise (our HTTP request function must throw an error)
  });

  let content;

  if (isPending) {
    content = "Please wait while the content loads..."
  }
  
  if (isError) {
    content = `An error occurred: ${error.info?.message || "Unable to connect to db."}`;
  }

  if (data) {
    content = JSON.stringify(data);
  }
  
  return (
    <>
    <h1>MySQL Results:</h1>
    <section>
      <div>
        <p>{content}</p>
      </div>
    </section>
    </>
  );
}
