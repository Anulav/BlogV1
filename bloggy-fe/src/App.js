import logo from './logo.svg';
import './App.css';
import NavBarComp from './NavBarComp'
import BlogsContainer from './BlogsContainer'
import Blogs from './Blogs';
import 'bootstrap/dist/css/bootstrap.min.css';
import WriterComp from './WriterComp';

function App() {
  return (
    <>
      <NavBarComp />
      {/* <BlogsContainer /> */}
      <WriterComp />
    </>
  );
}

export default App;
