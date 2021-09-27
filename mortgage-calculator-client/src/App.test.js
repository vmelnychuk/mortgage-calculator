import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Mortgage Calculator', () => {
  render(<App />);
  const logo = screen.getByText(/Mortgage Calculator/i);
  expect(logo).toBeInTheDocument();
});
