import styled from "styled-components";
import { useState, useCallback } from 'react';
import api from "../api";

const CriaEditoraWrapper = styled.div `

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

`

function CriaEditora() {

    const [nomeEditora, setNomeEditora] = useState("");

    const CriaEditoraApi = () => {
        
        const editora = {
            editoraNome: nomeEditora
        }

        api.post('/editoras', editora)
    }

    return(
        <CriaEditoraWrapper>
            <h3>Criar nova Editora</h3>
            <form className="cria-editora" onSubmit={CriaEditoraApi}>
                <input type={'text'} placeholder="Nome da Editora" onChange={(e) => setNomeEditora(e.target.value)} />
                <button type="submit">Criar editora</button>
            </form>
        </CriaEditoraWrapper>
    )

}

export default CriaEditora;