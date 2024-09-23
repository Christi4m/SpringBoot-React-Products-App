import { Button, Container, Navbar } from "react-bootstrap";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { logout } from "../store/auth.slice";

const NavigationBar = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleLogout = () => {
    dispatch(logout());

    navigate("/login");
  };

  return (
    <Navbar bg="light" expand="lg">
      <Container>
        <Navbar.Brand href="/products">Lexart APP</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <div className="w-100 d-flex flex-row-reverse">
            <Button variant="outline-danger" onClick={handleLogout}>
              Logout
            </Button>
          </div>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default NavigationBar;
