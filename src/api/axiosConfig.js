import axios from 'axios';

export default axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 30000,
    headers: {"Content-type":"application/json" }
});

{/* This is a comment in React 
export default axios.create({
    baseURL:'https://9c96-103-106-239-104.ap.ngrok.io',
    headers: {"ngrok-skip-browser-warning": "true"}
});*/}