import { useCallback, useState, useEffect } from "react/cjs/react.development";
import styled from "styled-components";
import api from "../api";

const CriaEmprestimoWrapper = styled.div`
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

function CriaEmprestimo() {

    const [livroemprestimo, setLivroEmprestimo] = useState([]);
    const [usuarioEmprestimo, setUsuarioEmprestimo] = useState([]);
    const [livroEscolhido, setLivroEscolhido] = useState(null);
    const [usuarioEscolhido, setUsuarioEscolhido] = useState(null);


    useEffect(() => {
        async function GetLivros() {
            const response = await api.get('/livros')
            setLivroEmprestimo(response.data);
        }
        GetLivros();
    }, [])

    useEffect(() => {
        async function GetUsuario() {
            const response = await api.get('/usuarios')
            console.log(response);
            setUsuarioEmprestimo(response.data);
        }
        GetUsuario();
    }, [])

    const CriaEmprestimo = useCallback((e) => {
        
        const emprestimo = {
            livro : {
                livroId: livroEscolhido
            },
            usuario: {
                usuarioId: usuarioEscolhido
            }
        }

        console.log(emprestimo)

        api.post("/emprestimos", emprestimo)
        
    }) 

    return (
        <CriaEmprestimoWrapper>
            <h3>Criar um novo emprestimo</h3>
            <form className="cria-emprestimo-form" onSubmit={CriaEmprestimo}>
                <select onChange={(e) => setLivroEscolhido(e.target.value)} value={livroEscolhido}>
                    <option value='default'>Nenhum</option>
                    {livroemprestimo?.map((livro) => (
                        <option key={livro.livroId} value={livro.livroId}>{livro.livroNome}</option>
                    ))}
                </select>
                <select onChange={(e) => setUsuarioEscolhido(e.target.value)} value={usuarioEscolhido}>
                    <option value='default'>Nenhum</option>
                    {usuarioEmprestimo?.map((usuario) => (
                        <option key={usuario.usuarioId} value={usuario.usuarioId}>{usuario.usuarioNome}</option>
                    ))}
                </select>
                <button type="submit">criar</button>
            </form>
        </CriaEmprestimoWrapper>
    )
}

export default CriaEmprestimo;