import { useEffect, useState, useCallback } from "react/cjs/react.development";
import api from "../api";
import styled from "styled-components";

const EditaUsuarioWrapper = styled.div `
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

    .cria-usuario-form{
        display: flex;
        flex-flow: column;
        align-items: center;
        justify-content: center;

        input {
            padding: 0.6rem;
            margin-top: 1%;
        }
    }
`;

function EditaUsuario({id}) {
    const[nome, setNome] = useState("");
    const[rg, setRg] = useState("");
    const[cpf, setCpf] = useState("");
    const[email, setEmail] = useState("");
    const[cep, setCep] = useState("");
    const[complemento, setComplemento] = useState("");
    const[numero, setNumero] = useState("");

    const EditaContato = useCallback(() => {

        const usuario = {
           usuarioNome: nome,
           rg: rg,
           cpf: cpf,
           email: email,
           endereco_url: `viacep.com.br/ws/${cep}/json/unicode/`,
           complemento: complemento,
           num: numero, 
        }

        api.put(`/usuarios/${id}`, usuario)
    }, [id, nome, rg, cpf, email, cep, complemento, numero])

    return(
        <EditaUsuarioWrapper>
            <h3>Editar Usuario</h3>
            <form className='cria-usuario-form' onSubmit={EditaContato}>
                <input placeholder='Nome' type={'text'} onChange={(e) => setNome(e.target.value)}/>
                <input placeholder='Rg' type={'text'} onChange={(e) => setRg(e.target.value)}/>
                <input placeholder='Cpf' type={'text'} onChange={(e) => setCpf(e.target.value)}/>
                <input placeholder='email' type={'text'} onChange={(e) => setEmail(e.target.value)}/>
                <input placeholder='CEP' type={'text'} onChange={(e) => setCep(e.target.value)}/>
                <input placeholder='Complemento' type={'text'} onChange={(e) => setComplemento(e.target.value)}/>
                <input placeholder='Numero' type={'text'} onChange={(e) => setNumero(e.target.value)}/>
                <button type='submit'>Alterar</button>
            </form>
        </EditaUsuarioWrapper>
    )
}

export default EditaUsuario;