import Home from './Paginas/Home';
import Emprestimos from './Paginas/Emprestimos';
import Usuarios from './Paginas/Usuarios';
import CriaLivro from './Paginas/CriaLivro';

import {Routes, Route} from 'react-router-dom';

function Rotas() {
    return (
        <Routes>
            <Route path="/" element={<Home />} exact />
            <Route path="/emprestimos" element={<Emprestimos />} />
            <Route path="/usuarios" element={<Usuarios />} />
            <Route path="/cria-livro" element={<CriaLivro />} />
        </Routes>
    )
}

export default Rotas;
