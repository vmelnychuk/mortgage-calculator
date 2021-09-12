import './App.css';
import Banks from './components/Banks';

function App() {
    return (
        <div className="container-fluid">
            <nav>
                <div className="nav-wrapper center-align">
                    <a href="/" className="brand-logo">Banks</a>
                </div>
            </nav>
            <div className="row">
                <Banks/>
            </div>
        </div>
    );
}

export default App;
