import api from '../api';
import { useState, useEffect, useCallback } from 'react';
import styled from 'styled-components';

const EditaLivroWrapper = styled.div`

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

function EditaLivro({id}) {
    useEffect(() => {
        async function getCategorias() {
          const response = await api.get('/categorias')
          console.log("categorias: ", response);
          SetCategorias(response.data)
        }
        getCategorias();
      }, [])
      
      useEffect(() => {
        async function getEditoras() {
          const response = await api.get('/editoras')
          console.log("editoras", response)
          setEditoras(response.data);
        }
        getEditoras();
      }, [])
      
      useEffect(() =>{
        async function getAutores() {
          const response = await api.get('/autores')
          console.log("autores: ", response)
          setAutores(response.data)
        }
        getAutores();
      }, [])

      const [categorias, SetCategorias] = useState([]);
      const [editoras, setEditoras] = useState([]);
      const [autores, setAutores] = useState([]);
      const [categoriaEscolhida, setCategoriaEscolhida] = useState(null);
      const [editoraEscolhida, setEditoraEscolhida] = useState(null);
      const [autorEscolhido, setAutorEscolhido] = useState(null);
      
      const[nomeLivro, setNomeLivro] = useState("");
      const [exemplares, setExemplares] = useState(null);

      const EditarLivro = useCallback((e) => {
        
        const livro = {
            livroNome: nomeLivro,
            exemplares,
            categoria: {
                categoriaId: categoriaEscolhida
            },
            autor: {
                autorId: autorEscolhido
            },
            editora: {
                editoraId: editoraEscolhida
            }
        }

        api.put(`/livros/${id}`, livro)    
    }, [id, nomeLivro, exemplares, categoriaEscolhida, autorEscolhido, editoraEscolhida])

    return (
        <EditaLivroWrapper>
            <form className='cria-livro-form' onSubmit={EditarLivro}>
                <input placeholder='nomeLivro' type={'text'} onChange={(e) => setNomeLivro(e.target.value)} />
                <input placeholder='Exemplares' type={'number'} onChange={(e) => setExemplares(e.target.value)} />
                <div className='categorias-livros'>
                <select onChange={(e) => setCategoriaEscolhida(e.target.value)} value={categoriaEscolhida}>
                    <option value='default'>nenhuma</option>
                    {categorias?.map((cat) => (
                    <option key={cat.categoriaId} value={cat.categoriaId}>{cat.categoriaNome}</option>
                    ))}
                </select>
                </div>
                <div className="editora">
                <select onChange={(e) => setEditoraEscolhida(e.target.value)} value={editoraEscolhida}>
                    <option value='default'>nenhuma</option>
                    {editoras?.map((ed) => (
                    <option key={ed.editoraId} value={ed.editoraId}>{ed.editoraNome}</option>
                    ))}
                </select>
                </div>
                <div className="autor">
                <select onChange={(e) => setAutorEscolhido(e.target.value)} value={autorEscolhido}>
                    <option value='default'>Nenhum</option>
                    {autores?.map((aut) => (
                    <option key={aut.autorId} value={aut.autorId}>{aut.autorNome}</option> 
                    ))}
                </select>
                </div>
                <button type='submit'>Editar Livro</button>
            </form>
        </EditaLivroWrapper>
    )
}

export default EditaLivro;