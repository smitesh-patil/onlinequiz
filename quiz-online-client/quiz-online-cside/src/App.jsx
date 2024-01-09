import { useState } from 'react'
import "bootstrap/dist/css/bootstrap.min.css"
import { BrowserRouter as Router, Routes,Route } from 'react-router-dom'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import NavBar from './components/layout/NavBar'
import GetAllQuiz from './components/quiz/GetAllQuiz'
import AddQuestion from './components/question/AddQuestion'

function App() {
  const [count, setCount] = useState(0)

  return (
    <main className='container mt-5 mb-5'>
      <Router>
        <NavBar/>
        <Routes>
          <Route path='/all-quizzes' element={<GetAllQuiz/>}></Route>
        <Route path='/create-quiz' element={<AddQuestion/>}></Route>
        </Routes>
      </Router>
    </main>
  )
}

export default App
