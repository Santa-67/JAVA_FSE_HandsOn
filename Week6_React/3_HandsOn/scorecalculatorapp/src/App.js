import logo from './logo.svg';
import './App.css';
import { CalculateScore } from './Components/CalculatorScore';

function App() {
  return (
    <div> 
      <CalculateScore 
        Name={"Steve"}
        School={"DNV Public School"}
        total={284}
        goal={3}
        />q
    </div>
  );
}

export default App;
