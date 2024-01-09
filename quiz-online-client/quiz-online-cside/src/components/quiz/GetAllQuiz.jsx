import React, { useEffect,useState } from 'react'
import { dleteQuestion, getAllQuestions } from '../../../utils/QuizService'
import "bootstrap/dist/css/bootstrap.min.css"
import { Link } from 'react-router-dom'
const GetAllQuiz = () => {
    const [questions, setQuestions] = useState([
		{ id: "", question: "", correctAnswers: "", choices: [] }
	])
	const [isLoading, setIsLoading] = useState(true)
	const [isQuestionDeleted, setIsQuestionDeleted] = useState(false)
	const [deleteSuccess, setDeleteSuccess] = useState("")

	useEffect(() => {
		fetchQuestions()
	}, [])

    const fetchQuestions= async()=>
    {
        try {
            const data =await getAllQuestions();
            setQuestions(data)
            setIsLoading(false)
        } catch (error) {
            console.error(error)
        }
    }

    const handleDelete= async(id)=>
    {
        try {
            await dleteQuestion(id)
            setQuestions(questions.filter((question)=>question.id!==id))
            setIsQuestionDeleted(true)
			setDeleteSuccess("Question deleted successfully.")
        } catch (error) {
            console.error(error)
        }
        setTimeout(() => {
			setDeleteSuccess("")
		}, 4000)
    }

    if (isLoading) {
		return <p>Loading...</p>
	}
  return (
   <section className='container'>
    <div className='row mt-5'>
        <div className='col-md-6 mb-2 md-mb-0' style={{ color: "GrayText" }}>
        <h4>All Quiz Questions</h4>
        </div>
        <div className='col-md-4 d-flex justify-content-end'>
            {/* to do add link to navigate to add new question form */}
        </div>
    </div>
    <hr />
    {isQuestionDeleted && <div className="alert alert-success">{deleteSuccess}</div>}

    {questions.map((question,index)=>(
        <div key={question.id}>
           <pre>
		<h4 style={{ color: "GrayText" }}>{`${index + 1}. ${question.question}`}
        </h4>
		   </pre>
			<ul>
			{question.choices.map((choice, index) => (
				<li key={index}>{choice}</li>
				))}
			</ul>
            <p className="text-success">Correct Answer: {question.correctAnswers}</p>
            <div className="btn-group mb-4">
				{/* <Link to={`/update-quiz/${question.id}`}>
				<button className="btn btn-sm btn-outline-warning mr-2">Edit Question</button>
				</Link> */}
			<button
			className="btn btn-sm btn-outline-danger"
		   onClick={() => handleDeleteQuestion(question.id)}>
			Delete Question
			</button>
			</div>
        </div>
    ))}
   </section>
  )
}

export default GetAllQuiz
