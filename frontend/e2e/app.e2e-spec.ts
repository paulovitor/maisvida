import { MaisvidaPage } from './app.po';

describe('maisvida App', () => {
  let page: MaisvidaPage;

  beforeEach(() => {
    page = new MaisvidaPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
