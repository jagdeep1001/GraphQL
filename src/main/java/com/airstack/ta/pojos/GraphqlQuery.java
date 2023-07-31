package com.airstack.ta.pojos;


//Main Pojo Class for complete query and json variable

public class GraphqlQuery {
    private String query;
    private Object variables;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Object getVariables() {
        return variables;
    }

    public void setVariables(Object variables) {
        this.variables = variables;
    }

    @Override
    public String toString() {
        return "GraphqlQuery{" +
                "query='" + query + '\'' +
                ", variables=" + variables +
                '}';
    }
}
