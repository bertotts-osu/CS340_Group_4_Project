import { StrictMode } from 'react'; //included to add extra checks (only runs in development)
import { createRoot } from 'react-dom/client';
import App from './App.jsx';
import './index.css';

//injects the App component into the root element defined in the index.html file
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
);
