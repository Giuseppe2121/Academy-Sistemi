import { useLocation, useNavigate, useParams } from "react-router-dom";

/*
Questo file diciara sotto forma di costante una funzione di JavScript
che centralizza e uniforma l'uso delle funzioni predefinite 
dell'API react-router-dom da parte di tutte le Component di progetto 

Ad esempio per ogni component basterà usare la variabile location 
per invocare e usare la funzione useLocation che è una delle 
funzioni predefinite da react-router-dom per gestire il flusso 
di navigazione 
*/
export const withRouter = (Component) => {
    function ComponentWithRouterProp(props) {
        let location = useLocation();
        let navigate = useNavigate();
        let params = useParams();
        return <Component {...props} router={{ location, navigate, params }} />;
    }
    return ComponentWithRouterProp;
};
