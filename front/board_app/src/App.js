import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'; 
import ListBoardComponent from './components/ListBoardComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateBoardComponent from './components/CreateBoardComponent';
import DetailBoardComponent from './components/DetailBoardComponent';
import MovieDataComponent from './components/MovieDataComponent';

function App() {
  return (
    <div> 
      <Router>
        <HeaderComponent/>
          <div className="container">
            <Switch>
              <Route path = "/" exact component = {ListBoardComponent}></Route>
              <Route path = "/board" component = {ListBoardComponent}></Route>
              <Route path = "/create-board/" component = {CreateBoardComponent}></Route>
              <Route path = "/read-board/:no" component = {DetailBoardComponent}></Route>
              <Route path = "/movieData" component = {MovieDataComponent}></Route>
            </Switch>
          </div>
        <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;
