import { useState, useEffect } from "react";
import Navbar from "../Components/Navbar";
import styled from 'styled-components';
import api from '../api';
import CriaUsuario from '../Components/CriaUsuario';
import EditarUsuario from "../Components/EditarUsuario";

const UsuariosWrapper = styled.div `
width: 78%;
background: #FFF;
margin-bottom: 5%;

    .div-usuarios {
        width: 100%;
        width: 100%;
        border-bottom: 1px solid #A6A2A2;
        display: flex;
        flex-flow: column;
        align-items: flex-start;
        justify-content: flex-start;

        h2 {
            padding: 0.5rem;
        }

        span {
            padding: 0.5rem;
        }
    }

    button {
        align-self: flex-start;
    }

    .editar {
        background-color: #0000ff;
        color: white;
        outline: none;
        border: none;
        border-radius: 3px;
        padding: 0.2rem;
        margin-right: 0.2rem;
      }

      .excluir {
        background-color: #ff0000;
        color: white;
        outline: none;
        border: none;
        border-radius: 3px;
        padding: 0.2rem;
      }

      .empty {
          display: none;
      }
`;

function Usuarios() {

    const [usuarios, SetUsuarios] = useState([]);
    const [modalUsuario, setModalUsuario] = useState(false);
    const [modalEditaUsuario, setModalEditaUsuario] = useState(false);
    const [usuarioId, setUsuarioId] = useState(null);

    useEffect(() => {
        async function GetUsuarios() {
            const response = await api.get('/usuarios')
            console.log(response)
            SetUsuarios(response.data);
        }
        GetUsuarios();
    }, [])

    async function deletaUsuario() {
        const resp = await api.delete(`/usuarios/${usuarioId}`)
        window.location.reload();
    }

    return(
        <div className="container-fluid mt-5 pt-3 text-center">
            <h2>Sistema Bibliotecário</h2>
            <h4>Usuarios</h4>
            <div className="container d-flex justify-content-between mt-5 pt-3">
                <Navbar />
                <UsuariosWrapper>
                    <button onClick={() => setModalUsuario(!modalUsuario)}>Criar Usuario</button>
                    {usuarios.map(user =>
                    <div className="div-usuarios" key={user.usuarioId}>
                        <div className="div-usuarios-buttons">

                            <button className="editar" onClick={() => {
                                setUsuarioId(user.usuarioId);
                                setModalEditaUsuario(!modalEditaUsuario);
                            }}>Editar</button>

                            <button className="excluir" onClick={() => {
                                setUsuarioId(user.usuarioId);
                                deletaUsuario();
                            }}>Excluir</button>
                        </div>
                        <h2>{user.usuarioNome}</h2>
                        <span><b>Email: </b>{user.email}</span>
                    </div>    
                    )}
                    {modalUsuario ? 
                        <CriaUsuario />
                        :
                        <div className="empty"></div>
                    }

                    {modalEditaUsuario && usuarioId &&
                        <EditarUsuario id={usuarioId}/>
                    }
                </UsuariosWrapper>
            </div>
        </div>
    )
}

export default Usuarios;