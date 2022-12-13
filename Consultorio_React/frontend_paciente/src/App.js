import logo from './logo.svg';
import './App.css';
import Menu from './components/Menu';
import Login from './components/Login';
import Logout from './components/Logout';
import Cita from './components/Citas';
import Registro from './components/Registro';
import { HashRouter,BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <div className="App-header">
        <Menu/>

        <BrowserRouter>
          <Routes>
            <Route path='/login' element={<Login />} />
            <Route path='/logout' element={<Logout />} />
            <Route path='/logout' element={<Logout />} />
            <Route path='/citas' element={<Cita />} />
            <Route path='/registro' element={<Registro />} />
          </Routes>
        </BrowserRouter>
      </div>
    </div>
  );
}

export default App;
