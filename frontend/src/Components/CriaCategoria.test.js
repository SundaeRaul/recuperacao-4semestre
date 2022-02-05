import { render, screen, fireEvent } from "@testing-library/react";
import '@testing-library/jest-dom/extend-expect';
import axios from "axios";
import React from "react";
import CriaCategora from './CriaCategoria';

const mockCategoria = {
    categoriaId: 4,
    categoriaNome: "qwe12",
    limiteEmprestimo: 2,
    livros: []
}

test("Deve chamar a api", () => {
    axios.post.mockImplementation(() => Promise.resolve(mockCategoria));
    render(<CriaCategora />)

    const inputNome = screen.getByTestId(/nome-categoria/i)
    const inputLimite = screen.getByTestId(/limite-categoria/i)
    const button = screen.getByTestId(/cria-categoria/i)

    fireEvent.change(inputNome, { target: { value : "qwe12"}});
    fireEvent.change(inputLimite, { target: { value: 2 }});
    fireEvent.click(button);

    expect(inputNome).toBeInTheDocument();
    expect(inputLimite).toBeInTheDocument();
    expect(axios.post).toHaveBeenCalled();
})
