import { Navigate, RouterProvider, createBrowserRouter } from "react-router-dom";
import { QueryClientProvider, QueryClient } from "@tanstack/react-query";
import HomePage from './components/HomePage.jsx';

export default function App() {
  //create router prop that configures what elements are displayed for each path
  const router = createBrowserRouter([
    {
      path: "/",
      element: <Navigate to="/MySQL/Diagnostic" replace />,
    },
    {
      path: "/MySQL/Diagnostic",
      element: <HomePage/>,
    },
  ]);

  // create a query client that is responsible for managing the cache and fetching data
  const queryClient = new QueryClient();

  return (
    //QueryClientProvider is a wrapper that enables components to access the query client
    <QueryClientProvider client={queryClient}>
      <RouterProvider router={router} />
    </QueryClientProvider>
  );
}
