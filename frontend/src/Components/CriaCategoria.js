import { useState } from "react";
import { useCallback } from "react/cjs/react.development";
import styled from "styled-components"
import api from "../api";

const CriaCategoriaWrapper = styled.div `

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

function CriaCategoria() {

    const [nomeCategoria, setNomeCategoria] = useState("");
    const [limiteEmprestimo, setLimiteEmprestimo] = useState(null);

    const CriaCategoria = () => {
        const categoria = {
            categoriaNome: nomeCategoria,
            limiteEmprestimo: limiteEmprestimo
        }

        api.post("/categorias", categoria);

    }

    return(
        <CriaCategoriaWrapper data-testid="form">
            <h3>Criar nova categoria</h3>
            <form className="cria-categoria" onSubmit={CriaCategoria}>
                <input placeholder="Nome da Categoria" data-testid="nome-categoria" type={'text'} onChange={(e) => setNomeCategoria(e.target.value)}/>
                <input placeholder="Limite de Emprestimo" data-testid="limite-categoria" type={'number'} onChange={(e) => setLimiteEmprestimo(e.target.value)}/>
                <button type="submit" data-testid="cria-categoria">Criar Categoria</button>
            </form>
        </CriaCategoriaWrapper>
    )
}

export default CriaCategoria;