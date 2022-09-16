import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from './pages/Home';
import Profile from "./pages/Profile";
import SingInPage from "./pages/SignInPage";
import SingUpPage from './pages/SignUpPage';
import Movies from "./pages/Movies";

function App() {
  return <div className="App">
    <Router>

      <Routes>
         <Route path="/" element={<Home></Home>}></Route>
      </Routes>

      <Routes>
         <Route path="/profile" element={<Profile></Profile>}></Route>
      </Routes>

      <Routes>
         <Route path="/signin" element={<SingInPage></SingInPage>}></Route>
      </Routes>

      <Routes>
         <Route path="/signup" element={<SingUpPage></SingUpPage>}></Route>
      </Routes>

      <Routes>
         <Route path="/movies" element={<Movies></Movies>}></Route>
      </Routes>

    </Router>
  </div>
}

export default App;
