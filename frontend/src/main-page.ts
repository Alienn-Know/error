class MainPage extends LitElement {
  render() {
    return html`
      <div id="content"></div>
      <button id="helloButton">Click me!</button>

    `;
  }
}

customElements.define('main-page', MainPage);