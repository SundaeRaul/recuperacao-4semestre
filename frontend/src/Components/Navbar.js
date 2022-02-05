import { Link } from 'react-router-dom';
import styled from 'styled-components';

const NavWrapper = styled.div`
    width: 18%;
    height: 40%;
    background-color: white;
    display: flex;
    flex-flow: column nowrap;
    align-items: center;
    justify-content: center;
    padding-bottom: 30%;

    button {
        width: 80%;
        border: none;
        outline: none;
        background-color: white;
        padding: 5%;
        text-align: left;
        border-bottom: 1px solid #A6A2A2;
        color: #A6A2A2;
        transition: .3s;
    }

    button:last-child {
        border-bottom: none;
    }

    button:hover {
        color: black;
        border-bottom: 1px solid black;
    }

    button:last-child:hover {
        color: black;
        border-bottom: none;
    }

    a {
        width: 100%;
    }
`;


function Navbar() {
    return(
        <NavWrapper>
            <Link to="/">
                <button>Livros</button>
            </Link>
            <Link to="/emprestimos">
                <button>Empréstimos</button>
            </Link>
            <Link to="/usuarios">
                <button>Usuarios</button>
            </Link>
        </NavWrapper>
    )
}

export default Navbar;