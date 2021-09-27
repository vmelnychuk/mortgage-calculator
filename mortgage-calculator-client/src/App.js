import "./App.css";
import "semantic-ui-css/semantic.min.css";
import Create from "./components/Create";
import Read from "./components/Read";
import Update from "./components/Update";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

function App() {
    return (
        <Router>
            <div className="main">
                <h2 className="main-header"><Link to="/">Mortgage Calculator</Link></h2>
                <ul>
                    <li>
                        <Link to="/create">Create new bank</Link>
                    </li>
                    <li>
                        <Link to="/read">Bank dashboard</Link>
                    </li>
                </ul>
                <div>
                    <Route exact path="/create" component={Create} />
                </div>
                <div style={{ marginTop: 20 }}>
                    <Route exact path="/read" component={Read} />
                </div>
                <Route path="/update" component={Update} />
            </div>
        </Router>
    );
}

export default App;
