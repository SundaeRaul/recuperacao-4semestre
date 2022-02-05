import api from '../api';
import styled from 'styled-components';
import { useEffect } from 'react';
import { useCallback, useState } from 'react/cjs/react.development';
import Navbar from '../Components/Navbar';
import CriaCategoria from '../Components/CriaCategoria';

const CriaLivroWrapper = styled.div`
width: 78%;
background: #FFF;
margin-bottom: 5%;

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

function CriaLivro(){

    const [categorias, SetCategorias] = useState([]);
    const [editoras, setEditoras] = useState([]);
    const [autores, setAutores] = useState([]);
    const [categoriaEscolhida, setCategoriaEscolhida] = useState(null);
    const [editoraEscolhida, setEditoraEscolhida] = useState(null);
    const [autorEscolhido, setAutorEscolhido] = useState(null);
    
    const[nomeLivro, setNomeLivro] = useState("");
    const [exemplares, setExemplares] = useState(null);

    const [modalCriaCategoria, setModalCriaCategoria] = useState(false);

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

      const CriaLivro = useCallback((e) => {
        
        const livro = {
            livroNome: nomeLivro,
            exemplares: exemplares,
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

        api.post("/livros", livro)    
    }) 

    return (
      <div className='container-fluid mt-5 pt-5 text-center'>
        <h2>Sistema Bibliotecário</h2>
        <h4>Criar livro</h4>
          <div className='container d-flex justify-content-between mt-5 pt-5'>
            <Navbar />
          <CriaLivroWrapper>
              <form className='cria-livro-form' onSubmit={CriaLivro}>
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
                  <button type='button' onClick={(e) => setModalCriaCategoria(!modalCriaCategoria)}>Ou criar nova categoria</button>
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
                  <button type='submit'>Criar Livro</button>
              </form>

              {modalCriaCategoria ?
                <CriaCategoria />
               : 
                <div></div>
              }
          </CriaLivroWrapper>
        </div>
      </div>
    )
}

export default CriaLivro;