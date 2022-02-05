import { useState } from "react";
import styled from "styled-components";
import api from "../api";

const CriaAutorWrapper = styled.div`
width: 40%;
background-color: #0000ff;
display: flex;
flex-flow: column;
align-items: center;
justify-content: center;
position: absolute;
top: 20%;
color: white;

    h3 {
        margin-top: 1%;
    }

    form {
        display: flex;
        flex-flow: column;
        justify-content: center;
        align-items: center;

        input {
            padding: .5rem;
        }
    }
`;

function CriaAutor() {

    const [nomeAutor, setNomeAutor] = useState("");

    const CriaAutorApi = () => {

        const autor = {
            autorNome: nomeAutor
        }

        api.post("/autores", autor)
    }

    return(
        <CriaAutorWrapper>
            <h3>Criar um autor</h3>
            <form onSubmit={CriaAutorApi}>
                <input type={'text'} placeholder="nome do autor" onChange={(e) => setNomeAutor(e.target.value)} />
                <button type="submit">Criar autor</button>
            </form>
        </CriaAutorWrapper>
    )
}

export default CriaAutor;