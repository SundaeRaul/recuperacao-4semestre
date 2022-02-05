import Navbar from "../Components/Navbar";
import styled from 'styled-components';
import { useEffect, useState } from "react";
import api from '../api';
import EditarLivro from '../Components/EditarLivro';
import { Link } from "react-router-dom";

const HomeWrapper = styled.div`
  width: 78%;
  background: #FFF;
  margin-bottom: 5%;

  .filters {
    width: 100%;
    border-bottom: 10px solid #A6A2A2;
    display: flex;
    flex-flow: column;
    alignt-items: center;
    justify-content: flex-start;

    h5 {
      padding: 0.5rem;
    }

    .filters-select {
      width: 100%;
      margin-bottom: 0.5rem;
      display: flex;
      align-items: center;
      justify-content: space-around;
    }
  }

  .div-livro {
    width: 100%;
    display: flex;
    flex-flow: column nowrap;
    align-items: flex-start;
    border-bottom: 1px solid #A6A2A2;

    .div-livro-header{
      width: 100%;
      display: flex;
      justify-content: space-between;
      align-items: center;

      h2 {
        padding: 0.5rem;
      }

      .div-livro-header-buttons {
        padding: 0.5rem;
        display: flex;
        align-items: flex-end;
        justify-content: space-evenly;

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
      }
    } 

    .livro-data {
      width: 100%;
      display: flex;
      align-items: flex-start;
      justify-content: space-between;

      .livro-data-text {
        display: flex;
        flex-flow: column nowrap;
        align-items: flex-start;
        justify-content: center;
        
        span {
          padding: 0.5rem;
        }
      }

      .livro-data-qtt {
        font-size: 1.3rem;
        display: flex;
        align-items: center;
        justify-content: end;

        span {
          padding: 0.5rem;
        }
      }
    }
  }
`;


function App() {

  const [livros, SetLivros] = useState([]);
  const [categorias, SetCategorias] = useState([]);
  const [editoras, setEditoras] = useState([]);
  const [autores, setAutores] = useState([]);
  const [categoriaEscolhida, setCategoriaEscolhida] = useState(null);
  const [editoraEscolhida, setEditoraEscolhida] = useState(null);
  const [autorEscolhido, setAutorEscolhido] = useState(null);
  const [livroid, SetLivroid] = useState(null);

  const [showEditaLivro, setShowEditaLivro] = useState(false);

  useEffect(() => {
    async function GetLivros() {
        const response = await api.get('/livros')
        console.log(response);
        SetLivros(response.data);
    }
    GetLivros();
}, [])

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



  async function deletaLivro() {
    const resp = await api.delete(`/livros/${livroid}`)
    window.location.reload()

  }

  console.log(livroid)
  console.log("state shhow modal editar livro: ", showEditaLivro)

  return (
    <div className="container-fluid mt-5 pt-3 text-center">
      <h2>Sistema Bibliotecário</h2>
      <div className="container d-flex justify-content-between mt-5 pt-3">
        <Navbar />
        <HomeWrapper>
            <Link to="/cria-livro">
              <button>Criar Livro</button>
            </Link>
          {livros.map((livro, index) => 
            <div className="div-livro" data-testid={`livro-${index}`} key={livro.livroId}>
              <div className="div-livro-header">
                <h2>{livro.livroNome}</h2>
                <div className="div-livro-header-buttons">
                  <button className="editar" onClick={() => {
                    SetLivroid(livro.livroId);
                    setShowEditaLivro(!showEditaLivro)
                  }}>Editar</button>
                  <button className="excluir"
                    onClick={() => {
                      SetLivroid(livro.livroId);
                      deletaLivro();
                    }}
                  >Excluir</button>
                </div>
              </div>
              <div className="livro-data">
                <div className="livro-data-text">
                  <span><b>Categoria: </b>{livro.categoria.categoriaNome}</span>
                  <span><b>Editora: </b>{livro.editora.editoraNome}</span>
                  <span><b>Autor: </b>{livro.autor.autorNome}</span>
                </div>
                <div className="livro-data-qtt">
                  <span><b>Quantidade: </b>{livro.exemplares}</span>
                </div>
              </div>
            </div>
          )}
          {showEditaLivro && livroid &&
            <EditarLivro id={livroid} />
          }
        </HomeWrapper>
      </div>
    </div>
  );
}

export default App;
