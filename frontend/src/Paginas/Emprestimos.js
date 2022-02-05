import { useState, useEffect } from 'react/cjs/react.development';
import styled from 'styled-components';
import Navbar from '../Components/Navbar';
import api from '../api';
import CriaEmprestimo from '../Components/CriaEmprestimo';

const EmprestimosWrapper = styled.div `
width: 78%;
background: #FFF;
margin-bottom: 5%;

    .div-emprestimo{
        width: 100%;
        border-bottom: 1px solid #A6A2A2;
        display: flex;
        flex-flow: column;
        align-items: flex-start;
        justify-content: center;

        h2 {
            padding: 0.5rem;
        }

        .multa {
            color: red;
        }
    }

    .excluir {
        background-color: #ff0000;
        color: white;
        outline: none;
        border: none;
        border-radius: 3px;
        padding: 0.2rem;
      }

`;

function Emprestimos(){

    const [emprestimo, SetEmprestimo] = useState([])
    const [showModal, setShowModal] = useState([false])
    const [emprestimoId, setEmprestimoId] = useState(null);

    useEffect(() => {
        async function GetEmprestimos() {
            const response = await api.get('/emprestimos')
            console.log(response);
            SetEmprestimo(response.data);
        }
        GetEmprestimos();
    }, [])

    async function DeletaEmprestimo() {
        const resp = await api.delete(`/emprestimos/${emprestimoId}`)
        window.location.reload();
    }

    const data = new Date();
    const dia = String(data.getDate());
    const mes = String(data.getMonth() + 1);
    const ano = data.getFullYear();
    const dataAtual = dia + '/' + mes + '/' + ano;
    console.log(dataAtual);

    return(
        <div className="container-fluid mt-5 pt-3 text-center">
            <h2>Sistema Bibliotecário</h2>
            <h4>Emprestimos</h4>
            <div className="container d-flex justify-content-between mt-5 pt-3">
                <Navbar />
                <EmprestimosWrapper>
                    <button onClick={() => setShowModal(!showModal)}>Cadastrar Novo Emprestimo</button>
                    {emprestimo.map(emp =>
                    <div className='div-emprestimo' key={emp.emprestimoId}>
                        <button className='excluir' onClick={() => {
                            setEmprestimoId(emp.emprestimoId);
                            DeletaEmprestimo();
                        }}>Excluir</button>
                        <h2>{emp.usuario.usuarioNome}</h2>
                        <span><b>Livro: </b>{emp.livro.livroNome}</span>
                        <span><b>Data de emprestimo: </b>{emp.data[2]}/{emp.data[1]}/{emp.data[0]}</span>
                        <span><b>Data de devolução: </b>{emp.dataLimite[2]}/{emp.dataLimite[1]}/{emp.dataLimite[0]}</span>
                        {emp.dataLimite[2] >= dataAtual ?
                        <span className='multa'>Aplicar multa</span>
                        :
                        <span></span>
                        } 
                    </div>
                    )}
                    {showModal === true ? 
                    <CriaEmprestimo />
                    :
                    <div></div>
                    }
                </EmprestimosWrapper>
            </div>
        </div>
    )
}

export default Emprestimos;