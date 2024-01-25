import React, { useState } from "react";
import "./HomePage.css";
import cachorroImage from "../images/cachorro.png";

function HomePage() {
  const [quantidadeCaesPequenos, setQuantidadeCaesPequenos] = useState(0);
  const [quantidadeCaesGrandes, setQuantidadeCaesGrandes] = useState(0);
  const [data, setData] = useState("");
  const [petShopsOptions, setPetShopsOptions] = useState([]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!data) {
      console.error("Por favor, selecione uma data.");
      return;
    }

    try {
      const dataFormatada = new Date(data).toISOString().split("T")[0];
      const url = `http://localhost:8080/best-options?data=${dataFormatada}&cachorroPequeno=${quantidadeCaesPequenos}&cachorroGrande=${quantidadeCaesGrandes}`;

      const response = await fetch(url);

      if (!response.ok) {
        throw new Error("Houve um problema com a resposta da rede");
      }

      const dados = await response.json();
      setPetShopsOptions(dados);
    } catch (error) {
      console.error("Houve um problema com a operação de fetch:", error);
    }
  };

  const getOptionTitle = (index) => {
    switch (index) {
      case 0:
        return <span className="ouro-pastel">1º</span>;
      case 1:
        return <span className="prata-pastel">2º</span>;
      case 2:
        return <span className="bronze-pastel">3º</span>;
      default:
        return "";
    }
  };

  return (
    <div className="container">
      <div className="home-page">
        <div className="container-pesquisa">
          <div className="header">
            <img
              src={cachorroImage}
              alt="Pet Shop"
              className="imagem-cachorro"
            />
            <h1 className="texto-principal">
              Encontre o Melhor Pet Shop com custo beneficio!
            </h1>
          </div>
          <form onSubmit={handleSubmit} className="form">
            <div className="container-input">

            
            <div className="input-group">
              <label>Quantidade de Cães Pequenos:</label>
              <input
                type="number"
                value={quantidadeCaesPequenos}
                onChange={(e) => setQuantidadeCaesPequenos(Math.max(0, e.target.value))}
                className="inputs"
              />
            </div>
            <div className="input-group">
              <label>Quantidade de Cães Grandes:</label>
              <input
                type="number"
                value={quantidadeCaesGrandes}
                onChange={(e) => setQuantidadeCaesGrandes(Math.max(0, e.target.value))}
                className="inputs"
              />
            </div>
            <div className="input-group">
              <label>Data:</label>
              <input
                type="date"
                value={data}
                onChange={(e) => setData(e.target.value)}
                className="inputs"
              />
            </div>

            <button type="submit" className="botao">
              Encontrar
            </button>
            </div>
          </form>
        </div>
        {petShopsOptions.length > 0 && (
          <div className="resultado">
            {petShopsOptions.map((option, index) => (
              <div key={index}>
                <h2>
                  {getOptionTitle(index)} {option.petShop.nome}
                </h2>
                <p>Distância: {option.petShop.distancia} km</p>
                <p>Custo total: R$ {option.custoTotal.toFixed(2)}</p>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}

export default HomePage;
